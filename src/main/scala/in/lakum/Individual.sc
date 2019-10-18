import java.time.LocalDate

// sealed trait can only be extended within the file in which it defined.

sealed trait GenderEnum extends scala.AnyRef {
  def value: String
}

// final case class cannot be extended by any other class.
// nobody can subclass your class or override its internal state or behavior.

final case object GenderEnumFemale extends GenderEnum {
  override val value: String = "female"
}
final case object GenderEnumMale extends GenderEnum {
  override val value: String = "male"
}
final case object GenderEnumOther extends GenderEnum {
  override val value: String = "other"
}

sealed trait MaritalStatusEnum extends scala.AnyRef {
  def value: String
}
final case object MaritalStatusEnumCohabiting extends MaritalStatusEnum {
  override val value: String = "cohabiting"
}
final case object MaritalStatusEnumDivorced extends MaritalStatusEnum {
  override val value: String = "divorced"
}
final case object MaritalStatusEnumMarried extends MaritalStatusEnum {
  override val value: String = "married"
}
final case object MaritalStatusEnumSingle extends MaritalStatusEnum {
  override val value: String = "single"
}
final case object MaritalStatusEnumWidowed extends MaritalStatusEnum {
  override val value: String = "widowed"
}

case class Individual(
                       id: String,
                       firstName: String,
                       middleName: String,
                       lastName: String,
                       gender: Option[GenderEnum],
                       placeOfBirth: Option[String],
                       countryOfBirth: Option[String],
                       dateOfBirth: Option[LocalDate],
                       nationality: Option[String],
                       maritalStatus: Option[MaritalStatusEnum],
                       language: Option[String]
                     )

// An object with same name as the class object is a companion object and the class is called a companion class.

object Individual {
  def create(id: String,
             firstName: String,
             middleName: String,
             lastName: String,
             gender: Option[GenderEnum],
             placeOfBirth: Option[String],
             countryOfBirth: Option[String],
             dateOfBirth: Option[LocalDate],
             nationality: Option[String],
             maritalStatus: Option[MaritalStatusEnum],
             language: Option[String]): Individual = {
    new Individual(
      id = id,
      firstName = firstName,
      middleName = middleName,
      lastName = lastName,
      gender = gender,
      placeOfBirth = placeOfBirth,
      countryOfBirth = countryOfBirth,
      dateOfBirth = dateOfBirth,
      nationality = nationality,
      maritalStatus = maritalStatus,
      language = language
    )
  }
}

val genders: Set[String] = Set(GenderEnumMale.value, GenderEnumFemale.value, GenderEnumOther.value)

val maritalStatuses: Set[String] = Set(MaritalStatusEnumSingle.value,
  MaritalStatusEnumCohabiting.value,
  MaritalStatusEnumMarried.value,
  MaritalStatusEnumDivorced.value,
  MaritalStatusEnumWidowed.value
)

val tolkein = Individual.create(
  "BRIT-001",
  "John",
  "Ronald Reuel",
  "Tolkien",
  Option(GenderEnumMale),
  Some("Bloemfontein"),
  Some("South Africa"),
  Some(LocalDate.parse("1892-01-03")),
  Some("British"),
  Option(MaritalStatusEnumWidowed),
  Some("English")
)
