package by.myfirstweb.test.service.impl;

import by.myfirstweb.test.domain.to.Auto;
import by.myfirstweb.test.service.validator.ServiceException;

public interface AutoService extends GenericServiceInterface<Auto, Auto> {

    Auto createAuto (Auto auto) throws SecurityException, ServiceException;
}
