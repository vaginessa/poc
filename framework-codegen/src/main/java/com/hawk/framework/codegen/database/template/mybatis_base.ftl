	<sql id="columns">
		<#list fieldList as field>
		${field.columnName} AS "${field.fieldName}" <#if field_has_next>,</#if>
		</#list>
	</sql>
	
	<sql id="where">
		<trim prefix="WHERE" prefixOverrides="AND|OR">		 
		<#list fieldList as field>		   
			<if test="${field.fieldName} != null"> AND ${field.columnName} = ${r"#"}{${field.fieldName}}  </if>
		</#list>
		</trim>	
	</sql>
	
	<sql id="where_old">
		<trim prefix="WHERE" prefixOverrides="AND|OR">
		<#list fieldList as field>
			AND ${field.columnName} = ${r"#"}{old_${field.fieldName}}
		</#list>
		</trim>
	</sql>
	
	<sql id="update">
		<set>
		<#list fieldList as field> 
			${field.columnName} = ${r"#"}{${field.fieldName}},
		</#list>
		</set>
	</sql>
	
	<sql id="updateWithoutNull">
		<set>
		<#list fieldList as field> 
			<if test="${field.fieldName} != null">${field.columnName} = ${r"#"}{${field.fieldName}},</if>
		</#list>
		</set>
	</sql>
	
	<#if (keyList?? && keyList?size>0)>
	<sql id="pkwhere">
		<trim prefix="WHERE" prefixOverrides="AND">
		<#list keyList as field>
			AND ${field.columnName} = ${r"#"}{${field.fieldName}}
		</#list>
		</trim>
	</sql>
	</#if>
	
	<#if (keyList?? && keyList?size>0)>
	<select id="load"  resultType="${className}Domain">
		SELECT 
		<include refid="columns" />
		FROM ${tableName}
		<include refid="pkwhere" />		
	</select>
	</#if>
	
	<select id="loadDynamic" parameterType="hashmap" resultType="${className}Domain">
		SELECT 		
		<include refid="columns" />
		FROM ${tableName}
		<include refid="where" />
		<if test="_orderby != null">ORDER BY ${r"$"}{_orderby}</if>
	</select>

	<select id="count"  parameterType="hashmap" resultType="integer">
		SELECT count(1) 
		FROM ${tableName}
		<include refid="where" />
	</select>
	
	<#if (keyList?? && keyList?size>0)>
	<select id="countByPK"  resultType="integer">
		SELECT count(1) 
		FROM ${tableName}
		<include refid="pkwhere" />		
	</select>
	</#if>
	
	<insert id="insert"  parameterType="${className}Domain">
		INSERT INTO ${tableName} (			
			<#list fieldList as field>
				${field.columnName}<#if field_has_next >,</#if>				
			</#list>
		)		
		VALUES (	
		<#list fieldList as field>
			${r"#"}{${field.fieldName}}<#if field_has_next >,</#if>
		</#list>	
		) 
	</insert>
	
	<#if (keyList?? && keyList?size>0)>
	<delete id="delete" >
		DELETE FROM ${tableName}
		<include refid="pkwhere" />	
	</delete>
	</#if>
	
	<delete id="deleteDynamic" parameterType="hashmap">
		DELETE FROM ${tableName}
		<include refid="where" />
	</delete>

	<#if (keyList?? && keyList?size>0)>
	<update id="update" parameterType="${className}Domain">
		UPDATE ${tableName}	
		<include refid="update" />
		<include refid="pkwhere" />	
	</update>
	</#if>
	
	<#if (keyList?? && keyList?size>0)>
	<update id="updateWithoutNull" parameterType="${className}Domain">
		UPDATE ${tableName}
		<include refid="updateWithoutNull"/>
		<include refid="pkwhere" />	
	</update>
	</#if>
	
	<update id="updateDynamic" parameterType="hashmap">
		UPDATE ${tableName}	
		<include refid="update" />
		<include refid="where_old" />
	</update>
	