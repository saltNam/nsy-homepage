package com.nsy.homepage.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHomepageQuestion is a Querydsl query type for HomepageQuestion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHomepageQuestion extends EntityPathBase<HomepageQuestion> {

    private static final long serialVersionUID = 1872792485L;

    public static final QHomepageQuestion homepageQuestion = new QHomepageQuestion("homepageQuestion");

    public final StringPath companyName = createString("companyName");

    public final StringPath content = createString("content");

    public final StringPath customerName = createString("customerName");

    public final StringPath email = createString("email");

    public final StringPath personalInfoAgreePeriod = createString("personalInfoAgreePeriod");

    public final StringPath personalInfoAgreeYn = createString("personalInfoAgreeYn");

    public final StringPath regTime = createString("regTime");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QHomepageQuestion(String variable) {
        super(HomepageQuestion.class, forVariable(variable));
    }

    public QHomepageQuestion(Path<? extends HomepageQuestion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHomepageQuestion(PathMetadata metadata) {
        super(HomepageQuestion.class, metadata);
    }

}

