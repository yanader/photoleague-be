package com.photoleague.entity.dto

import lombok.Builder
import lombok.Data
import java.time.LocalDateTime

@Data
@Builder
class ErrorDTO {
    private val message: String? = null
    private val time: LocalDateTime? = null
}