package com.leo.md_mvp.dagger.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Project: MD_MVP
 * Author: Leoying
 * Date: 2021/12/31 16:31
 * Desc:
 */
@Documented
@Qualifier
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CacheFile {
}
