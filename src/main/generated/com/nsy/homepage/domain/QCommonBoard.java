package com.nsy.homepage.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommonBoard is a Querydsl query type for CommonBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommonBoard extends EntityPathBase<CommonBoard> {

    private static final long serialVersionUID = 1474845546L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommonBoard commonBoard = new QCommonBoard("commonBoard");

    public final StringPath applyDate = createString("applyDate");

    public final StringPath category = createString("category");

    public final QCommonFile commonFile;

    public final StringPath contentSub = createString("contentSub");

    public final StringPath contentText = createString("contentText");

    public final StringPath contentUrl = createString("contentUrl");

    public final StringPath delYn = createString("delYn");

    public final NumberPath<Long> hitCnt = createNumber("hitCnt", Long.class);

    public final StringPath modMngrId = createString("modMngrId");

    public final StringPath modTime = createString("modTime");

    public final StringPath popupYn = createString("popupYn");

    public final StringPath regMngrId = createString("regMngrId");

    public final StringPath regTime = createString("regTime");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath subCategory = createString("subCategory");

    public final StringPath title = createString("title");

    public final StringPath topFixed = createString("topFixed");

    public final StringPath uploadFile = createString("uploadFile");

    public final StringPath useFrontYn = createString("useFrontYn");

    public final StringPath useUploadFileYn = createString("useUploadFileYn");

    public final StringPath useYn = createString("useYn");

    public QCommonBoard(String variable) {
        this(CommonBoard.class, forVariable(variable), INITS);
    }

    public QCommonBoard(Path<? extends CommonBoard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommonBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommonBoard(PathMetadata metadata, PathInits inits) {
        this(CommonBoard.class, metadata, inits);
    }

    public QCommonBoard(Class<? extends CommonBoard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commonFile = inits.isInitialized("commonFile") ? new QCommonFile(forProperty("commonFile"), inits.get("commonFile")) : null;
    }

}

