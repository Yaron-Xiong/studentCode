package com.accompnay.seftest.shorturl;

import com.accompnay.seftest.shorturl.dto.ShortUrlConfig;
import com.accompnay.seftest.shorturl.dto.ShortUrlDto;
import com.bt.devsp.common.Result;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ShortUrlClient {
    @RequestLine("POST /open-api/short-url/")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    Result<ShortUrlDto> creatShortUrl(ShortUrlConfig body);

    @RequestLine("PUT /open-api/short-url/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    Result<ShortUrlDto> updateShortUrl(@Param("id") long id, ShortUrlConfig body);
}
