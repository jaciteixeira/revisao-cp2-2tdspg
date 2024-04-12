package br.com.fiap.revisaocp22tdspg.resource;

import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ResourceDTO <Request, Response>{

    //ResponseEntity<Collection<Response>> findAll();

    ResponseEntity<Response> findById(Long id);

    ResponseEntity<Response> save(Request r);

    //ResponseEntity<Response> update(Request request);

    //ResponseEntity<Response> delete(Long id);

}
