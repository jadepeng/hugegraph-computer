/*
 * Copyright 2017 HugeGraph Authors
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.baidu.hugegraph.computer.algorithm.community.trianglecount;

import java.io.IOException;

import javax.ws.rs.NotSupportedException;

import com.baidu.hugegraph.computer.core.graph.value.IdList;
import com.baidu.hugegraph.computer.core.graph.value.LongValue;
import com.baidu.hugegraph.computer.core.graph.value.Value;
import com.baidu.hugegraph.computer.core.graph.value.ValueType;
import com.baidu.hugegraph.computer.core.io.RandomAccessInput;
import com.baidu.hugegraph.computer.core.io.RandomAccessOutput;
import com.baidu.hugegraph.computer.core.util.JsonUtil;

public class TriangleValue implements Value<TriangleValue> {

    private IdList idList;
    private LongValue value;

    public TriangleValue() {
        this.idList = new IdList();
        this.value = new LongValue();
    }

    public IdList idList() {
        return this.idList;
    }

    public long value() {
        return this.value.value();
    }

    public void value(Long value) {
        this.value.value(value);
    }

    @Override
    public ValueType valueType() {
        return ValueType.UNKNOWN;
    }

    @Override
    public void assign(Value<TriangleValue> other) {
        throw new NotSupportedException();
    }

    @Override
    public Value<TriangleValue> copy() {
        TriangleValue triangleValue = new TriangleValue();
        triangleValue.idList = this.idList.copy();
        triangleValue.value = this.value.copy();
        return triangleValue;
    }

    @Override
    public void read(RandomAccessInput in) throws IOException {
        this.idList.read(in);
        this.value.read(in);
    }

    @Override
    public void write(RandomAccessOutput out) throws IOException {
        this.idList.write(out);
        this.value.write(out);
    }

    @Override
    public int compareTo(TriangleValue other) {
        throw new NotSupportedException();
    }

    @Override
    public String toString() {
        return JsonUtil.toJson(this);
    }
}
