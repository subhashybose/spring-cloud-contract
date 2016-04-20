package io.codearte.accurest.dsl

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TypeChecked
import io.codearte.accurest.dsl.internal.Input
import io.codearte.accurest.dsl.internal.OutputMessage
import io.codearte.accurest.dsl.internal.Request
import io.codearte.accurest.dsl.internal.Response

@TypeChecked
@EqualsAndHashCode
@ToString(includeFields = true, includePackage = false, includeNames = true)
class GroovyDsl {

	Integer priority
	Request request
	Response response
	String label
	Input inputMessage
	OutputMessage outputMessage

	static GroovyDsl make(Closure closure) {
		GroovyDsl dsl = new GroovyDsl()
		closure.delegate = dsl
		closure()
		return dsl
	}

	void priority(int priority) {
		this.priority = priority
	}

	void label(String label) {
		this.label = label
	}

	void request(@DelegatesTo(Request) Closure closure) {
		this.request = new Request()
		closure.delegate = request
		closure()
	}

	void response(@DelegatesTo(Response) Closure closure) {
		this.response = new Response()
		closure.delegate = response
		closure()
	}

	void input(@DelegatesTo(Input) Closure closure) {
		this.inputMessage = new Input()
		closure.delegate = inputMessage
		closure()
	}

	void outputMessage(@DelegatesTo(OutputMessage) Closure closure) {
		this.outputMessage = new OutputMessage()
		closure.delegate = outputMessage
		closure()
	}

}
