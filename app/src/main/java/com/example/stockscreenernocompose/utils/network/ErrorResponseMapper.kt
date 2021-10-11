package com.example.stockscreenernocompose.utils.network

import com.example.stockscreenernocompose.model.StockErrorResponse
import com.skydoves.sandwich.ApiErrorModelMapper
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message

object ErrorResponseMapper : ApiErrorModelMapper<StockErrorResponse> {

    override fun map(apiErrorResponse: ApiResponse.Failure.Error<*>): StockErrorResponse {
        return StockErrorResponse(apiErrorResponse.statusCode.code, apiErrorResponse.message())
    }
}