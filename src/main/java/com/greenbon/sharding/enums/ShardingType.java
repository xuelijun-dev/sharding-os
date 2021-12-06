/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.greenbon.sharding.enums;

public enum ShardingType {
    /**
     * 取模分片
     */
    MOD_SHARDING_TABLES,

    /**
     * 月份分片(表尾缀必须:yyyyMM,如:t_table_yyyyMM)
     */
    MONTH_SHARDING_TABLES,

    /**
     * 季度分片(表尾缀必须:yyyyMM,如:t_table_yyyyMM)
     */
    QUARTER_SHARDING_TABLES,

    /**
     * 年度分片(表尾缀必须:yyyy,如:t_table_yyyy)
     */
    YEAR_SHARDING_TABLES,

    SHARDING_TABLES,

    SHARDING_DATABASES,

    SHARDING_DATABASES_AND_TABLES,
    
    SHARDING_SHADOW_DATABASES,
    
    ENCRYPT_SHADOW,

    READWRITE_SPLITTING,

    READWRITE_SPLITTING_SHADOW,
    
    SHARDING_READWRITE_SPLITTING,
    
    ENCRYPT,
    
    SHADOW,
    
    SHADOW_DEFAULT_ALGORITHM,
    
    SHARDING_AUTO_TABLES,

    SHARDING_HINT_DATABASES_ONLY,

    SHARDING_HINT_DATABASES_TABLES,

    READWRITE_SPLITTING_HINT
}
