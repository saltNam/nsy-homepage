package com.nsy.homepage.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommonFile is a Querydsl query type for CommonFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommonFile extends EntityPathBase<CommonFile> {

    private static final long serialVersionUID = -1614878600L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommonFile commonFile = new QCommonFile("commonFile");

    public final QCommonBoard f;

    public final StringPath fileName = createString("fileName");

    public final StringPath filePath = createString("filePath");

    public final StringPath fileType = createString("fileType");

    public final StringPath orgName = createString("orgName");

    public final DateTimePath<java.time.LocalDateTime> regTime = createDateTime("regTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QCommonFile(String variable) {
        this(CommonFile.class, forVariable(variable), INITS);
    }

    public QCommonFile(Path<? extends CommonFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommonFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommonFile(PathMetadata metadata, PathInits inits) {
        this(CommonFile.class, metadata, inits);
    }

    public QCommonFile(Class<? extends CommonFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.f = inits.isInitialized("f") ? new QCommonBoard(forProperty("f"), inits.get("f")) : null;
    }

}

