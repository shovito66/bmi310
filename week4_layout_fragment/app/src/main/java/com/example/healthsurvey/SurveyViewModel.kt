package com.example.healthsurvey
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SurveyViewModel : ViewModel() {

    private val _personalInfo = MutableLiveData<PersonalInfo>()
    val personalInfo: LiveData<PersonalInfo> get() = _personalInfo

    private val _healthIndicators = MutableLiveData<HealthIndicators>()
    val healthIndicators: LiveData<HealthIndicators> get() = _healthIndicators

    init {
        _personalInfo.value = PersonalInfo(
            name = "Mr. A",
            age = "30",
            gender = "Male"
        )

        _healthIndicators.value = HealthIndicators(
            bloodPressure = "120/80 mmHg",
            weight = "70 kg",
            height = "175 cm"
        )
    }

}

data class PersonalInfo(
    val name: String,
    val age: String,
    val gender: String
)

data class HealthIndicators(
    val bloodPressure: String,
    val weight: String,
    val height: String
)
