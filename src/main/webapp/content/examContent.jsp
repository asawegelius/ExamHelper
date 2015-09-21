
	<jsp:useBean id="randQuestion"
					class="model.Question"
					scope="request"/>
	<p> First Question: </p>
	<p>
	$<jsp:getProperty name="randQuestion" property="name" />
	</p>
	<p>
	$<jsp:getProperty name="randQuestion" property="description" />
	</p>