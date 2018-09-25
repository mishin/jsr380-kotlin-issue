package de.darkatra.jsr380kotlinissue

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [NoNullElementsValidator::class])
@Target(allowedTargets = [FUNCTION, FIELD, ANNOTATION_CLASS, CONSTRUCTOR, VALUE_PARAMETER, TYPE_PARAMETER])
@Retention(AnnotationRetention.RUNTIME)
annotation class NoNullElements(
	val message: String = "must not contain null elements",
	val groups: Array<KClass<out Any>> = [],
	val payload: Array<KClass<out Payload>> = []
)