package team.store.redux

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProductOrderServiceSpec extends Specification {

    ProductOrderService productOrderService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ProductOrder(...).save(flush: true, failOnError: true)
        //new ProductOrder(...).save(flush: true, failOnError: true)
        //ProductOrder productOrder = new ProductOrder(...).save(flush: true, failOnError: true)
        //new ProductOrder(...).save(flush: true, failOnError: true)
        //new ProductOrder(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //productOrder.id
    }

    void "test get"() {
        setupData()

        expect:
        productOrderService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ProductOrder> productOrderList = productOrderService.list(max: 2, offset: 2)

        then:
        productOrderList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        productOrderService.count() == 5
    }

    void "test delete"() {
        Long productOrderId = setupData()

        expect:
        productOrderService.count() == 5

        when:
        productOrderService.delete(productOrderId)
        sessionFactory.currentSession.flush()

        then:
        productOrderService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ProductOrder productOrder = new ProductOrder()
        productOrderService.save(productOrder)

        then:
        productOrder.id != null
    }
}
