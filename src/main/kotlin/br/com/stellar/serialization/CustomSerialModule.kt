package br.com.stellar.serialization

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

val customSerialModule = SerializersModule {
    contextual(BigDecimal::class, BigDecimalSerializer)
    contextual(LocalDate::class, LocalDateSerializer)
    contextual(LocalDateTime::class, LocalDateTimeSerializer)
    contextual(Any::class, AnySerializer)
}

val customJson = Json {
    serializersModule = customSerialModule
    encodeDefaults = true
    ignoreUnknownKeys = true
}
