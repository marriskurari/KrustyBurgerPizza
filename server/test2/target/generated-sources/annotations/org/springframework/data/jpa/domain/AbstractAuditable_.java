package org.springframework.data.jpa.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractAuditable.class)
public abstract class AbstractAuditable_ extends org.springframework.data.jpa.domain.AbstractPersistable_ {

	public static volatile SingularAttribute<AbstractAuditable, Date> createdDate;
	public static volatile SingularAttribute<AbstractAuditable, Object> createdBy;
	public static volatile SingularAttribute<AbstractAuditable, Date> lastModifiedDate;
	public static volatile SingularAttribute<AbstractAuditable, Object> lastModifiedBy;

}

