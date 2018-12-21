package jeffpalmerquerytest

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class IndicationControllerSpec extends Specification implements ControllerUnitTest<IndicationController>, DataTest {

    void "Test the index action returns the correct model"() {
        setup:
        new Indication(name: 'Indication 1').save()
        new Indication(name: 'Indication 2').save()
        new Indication(name: 'Indication 3').save()

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        model.indicationList.size() == 3
        model.indicationInstanceCount == 3
    }

    void "Test the index action returns the correct model when no data exists"() {
        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.indicationList
        model.indicationInstanceCount == 0
    }

    Class[] getDomainClassesToMock() {
        Indication
    }
}
