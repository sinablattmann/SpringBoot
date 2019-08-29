package ch.noseryoung.plj.SpringBoot.Property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * This is the Service Layer
 * 
 * @author Sina
 */

@Service
public class PropertyService {

  private PropertyRepository propertyRepository;

  @Autowired
  public PropertyService(PropertyRepository propertyRepository) {
    this.propertyRepository = propertyRepository;
  }
}
