package projson.core

import projson.core.DateToText
import kotlin.reflect.KClass

/**
 * Indica que um certo propriedade deve ser ignorado na conversão para formato JSON.
 */

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class JsonIgnore

/**
 * Permite alterar o nome de uma chave na conversão para formato JSON.
 */

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class JsonProperty(val name: String)

/**
 * Indica que o valor de uma propriedade não dever ser apresentado, mas sim o deu id único.
 */

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Reference

/**
 * Permite customizar uma classe através de um plugin.
 */

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class JsonString(val DateToText: KClass<out DateToText>)