//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.fun.base.entities;

import java.io.Serializable;

public interface Entity extends Serializable {
    Long getId();

    Object getRepository();

    Class getRepositoryClass();
}
