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

package com.baidu.hugegraph.computer.core.combiner;

import com.baidu.hugegraph.computer.core.graph.properties.Properties;
import com.baidu.hugegraph.util.E;

public class OverwritePropertiesCombiner implements PropertiesCombiner {

    @Override
    public void combine(Properties v1, Properties v2, Properties result) {
        E.checkArgumentNotNull(v1, "The combine parameter v1 can't be null");
        E.checkArgumentNotNull(v2, "The combine parameter v2 can't be null");
        E.checkArgumentNotNull(result,
                               "The combine parameter result can't be null");

        E.checkArgument(v1 != result && v2 != result,
                        "The combine parameter result " +
                        "can't same with v1 or v2");

        result.clear();
        result.putAll(v2.get());
    }
}
