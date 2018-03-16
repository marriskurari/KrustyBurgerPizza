package org.springframework.data.jpa.repository.support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJpaMetamodelEntityInformationIntegrationTests_EntityWithIdClass is a Querydsl query type for EntityWithIdClass
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJpaMetamodelEntityInformationIntegrationTests_EntityWithIdClass extends EntityPathBase<JpaMetamodelEntityInformationIntegrationTests.EntityWithIdClass> {

    private static final long serialVersionUID = 1610440992L;

    public static final QJpaMetamodelEntityInformationIntegrationTests_EntityWithIdClass entityWithIdClass = new QJpaMetamodelEntityInformationIntegrationTests_EntityWithIdClass("entityWithIdClass");

    public final StringPath id1 = createString("id1");

    public final StringPath id2 = createString("id2");

    public QJpaMetamodelEntityInformationIntegrationTests_EntityWithIdClass(String variable) {
        super(JpaMetamodelEntityInformationIntegrationTests.EntityWithIdClass.class, forVariable(variable));
    }

    public QJpaMetamodelEntityInformationIntegrationTests_EntityWithIdClass(Path<? extends JpaMetamodelEntityInformationIntegrationTests.EntityWithIdClass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJpaMetamodelEntityInformationIntegrationTests_EntityWithIdClass(PathMetadata metadata) {
        super(JpaMetamodelEntityInformationIntegrationTests.EntityWithIdClass.class, metadata);
    }

}

