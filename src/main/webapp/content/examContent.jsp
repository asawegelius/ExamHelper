	<p>
	
	</p>
	<jsp:useBean id="randQuestion"
					class="model.Question"
					scope="request"/>
	<p> 
	chapter: <jsp:getProperty name="randQuestion" property="chapter" />
	</p>
	<p>
	question name: <jsp:getProperty name="randQuestion" property="name" />
	</p>
	<p>
	question :<jsp:getProperty name="randQuestion" property="description" />
	</p>