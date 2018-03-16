package org.springframework.data.jpa.repository.support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJpaMetamodelEntityInformationIntegrationTests_EntityWithNestedIdClass is a Querydsl query type for EntityWithNestedIdClass
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJpaMetamodelEntityInformationIntegrationTests_EntityWithNestedIdClass extends EntityPathBase<JpaMetamodelEntityInformationIntegrationTests.EntityWithNestedIdClass> {

    private static final long serialVersionUID = 8885737L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJpaMetamodelEntityInformationIntegrationTests_EntityWithNestedIdClass entityWithNestedIdClass = new QJpaMetamodelEntityInformationIntegrationTests_EntityWithNestedIdClass("entityWithNestedIdClass");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QJpaMetamodelEntityInformationIntegrationTests_EntityWithIdClass reference;

    public QJpaMetamodelEntityInformationIntegrationTests_EntityWithNestedIdClass(String variable) {
        this(JpaMetamodelEntityInformationIntegrationTests.EntityWithNestedIdClass.class, forVariable(variable), INITS);
    }

    public QJpaMetamodelEntityInformationIntegrationTests_EntityWithNestedIdClass(Path<? extends JpaMetamodelEntityInformationIntegrationTests.EntityWithNestedIdClass> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJpaMetamodelEntityInformationIntegrationTests_EntityWithNestedIdClass(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJpaMetamodelEntityInformationIntegrationTests_EntityWithNestedIdClass(PathMetadata metadata, PathInits inits) {
        this(JpaMetamodelEntityInformationIntegrationTests.EntityWithNestedIdClass.class, metadata, inits);
    }

    public QJpaMetamodelEntityInformationIntegrationTests_EntityWithNestedIdClass(Class<? extends JpaMetamodelEntityInformationIntegrationTests.EntityWithNestedIdClass> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reference = inits.isInitialized("reference") ? new QJpaMetamodelEntityInformationIntegrationTests_EntityWithIdClass(forProperty("reference")) : null;
    }

}

