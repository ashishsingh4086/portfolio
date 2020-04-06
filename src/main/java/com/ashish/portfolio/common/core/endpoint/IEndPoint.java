package com.ashish.portfolio.common.core.endpoint;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface IEndPoint<T> {
  EndPointResponse<?> getEntityByList();

  EndPointResponse<?> getEntityById(@PathVariable Long id);

  EndPointResponse<?> createEntity(@Valid @RequestBody T Class, Errors errors);

  EndPointResponse<?> updateEntity(@RequestBody T Class, @PathVariable Long id);
}
