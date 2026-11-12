package com.encurtadorurlk.link.service;

import com.encurtadorurlk.link.model.Url;
import com.encurtadorurlk.link.model.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository repository;

    public String encurtadorDeURL(String request){
        Url url = new Url();
        String newUrl = geradorDeURL(request);
        url.setUrlRaiz(request);
        url.setUrlEncurtada(newUrl);
        url.setData_expiracao(LocalDateTime.now().plusMinutes(2));
        repository.save(url);
        return url.getUrlEncurtada();
    }

    public String geradorDeURL(String url){
        String aleatorio = UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 10);
        return "www.com/"+aleatorio;
    }

    public String searchUrl(String short_url){
        System.out.println(short_url);
        Url urlByUrl = repository
                .findUrlByUrlEncurtada(short_url)
                .orElseThrow(() -> new IllegalArgumentException("Essa URL nao existe, por favor, encurte novamente"));
        System.out.println(urlByUrl.getUrlRaiz());
        return urlByUrl.getUrlRaiz();
    }

}
