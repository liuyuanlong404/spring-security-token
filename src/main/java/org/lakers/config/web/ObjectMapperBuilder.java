package org.lakers.config.web;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.MonthDayDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.YearDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.YearMonthDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.MonthDaySerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.YearMonthSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.YearSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.util.Objects;
import java.util.TimeZone;

/**
 * Created on 2023/3/8 10:43
 *
 * @author lakers
 */
public class ObjectMapperBuilder {

    private static final SimpleModule SIMPLE_MODULE;

    static {
        SIMPLE_MODULE = new SimpleModule()
                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DatePatternConstant.DATE_TIME_FORMATTER))
                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DatePatternConstant.DATE_TIME_FORMATTER))
                .addDeserializer(LocalDate.class, new LocalDateDeserializer(DatePatternConstant.DATE_FORMATTER))
                .addSerializer(LocalDate.class, new LocalDateSerializer(DatePatternConstant.DATE_FORMATTER))
                .addDeserializer(Year.class, new YearDeserializer(DatePatternConstant.YEAR_FORMATTER))
                .addSerializer(Year.class, new YearSerializer(DatePatternConstant.YEAR_FORMATTER))
                .addDeserializer(YearMonth.class, new YearMonthDeserializer(DatePatternConstant.YEAR_MONTH_FORMATTER))
                .addSerializer(YearMonth.class, new YearMonthSerializer(DatePatternConstant.YEAR_MONTH_FORMATTER))
                .addDeserializer(MonthDay.class, new MonthDayDeserializer(DatePatternConstant.MONTH_DAY_FORMATTER))
                .addSerializer(MonthDay.class, new MonthDaySerializer(DatePatternConstant.MONTH_DAY_FORMATTER))
                .addDeserializer(LocalTime.class, new LocalTimeDeserializer(DatePatternConstant.TIME_FORMATTER))
                .addSerializer(LocalTime.class, new LocalTimeSerializer(DatePatternConstant.TIME_FORMATTER))
                .addSerializer(Sensitive.class, new SensitiveSerializer());
    }

    public static ObjectMapper build(boolean pretty) {
        return new ObjectMapper()
                .findAndRegisterModules()
                .registerModule(SIMPLE_MODULE)
                .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
                // 序列化时格式化
                .configure(SerializationFeature.INDENT_OUTPUT, pretty)
                // 序列化枚举是使用下标
                .configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true)
                // 序列化时候遇到空对象不抛出异常
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                // 反序列化时候遇到不匹配的属性并不抛出异常
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                // 反序列化的时候如果是无效子类型,不抛出异常
                .configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false)
                // 设置时区
                .setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }

    public static class SensitiveSerializer extends JsonSerializer<Object> implements ContextualSerializer {

        private SensitiveStrategy sensitiveStrategy;

        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if (Objects.isNull(value) || StringUtils.isBlank(value.toString()) || Objects.isNull(sensitiveStrategy)) {
                return;
            }
            gen.writeString(sensitiveStrategy.getDesensitize().apply(value.toString()));
        }

        @Override
        public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
            Sensitive annotation = property.getAnnotation(Sensitive.class);
            if (Objects.nonNull(annotation) && Objects.equals(String.class, property.getType().getRawClass())) {
                this.sensitiveStrategy = annotation.value();
                return this;
            }
            return prov.findValueSerializer(property.getType(), property);
        }
    }
}
