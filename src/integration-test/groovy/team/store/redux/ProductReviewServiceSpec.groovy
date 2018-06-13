package team.store.redux

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProductReviewServiceSpec extends Specification {

    ProductReviewService productReviewService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ProductReview(...).save(flush: true, failOnError: true)
        //new ProductReview(...).save(flush: true, failOnError: true)
        //ProductReview productReview = new ProductReview(...).save(flush: true, failOnError: true)
        //new ProductReview(...).save(flush: true, failOnError: true)
        //new ProductReview(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //productReview.id
    }

    void "test get"() {
        setupData()

        expect:
        productReviewService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ProductReview> productReviewList = productReviewService.list(max: 2, offset: 2)

        then:
        productReviewList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        productReviewService.count() == 5
    }

    void "test delete"() {
        Long productReviewId = setupData()

        expect:
        productReviewService.count() == 5

        when:
        productReviewService.delete(productReviewId)
        sessionFactory.currentSession.flush()

        then:
        productReviewService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ProductReview productReview = new ProductReview()
        productReviewService.save(productReview)

        then:
        productReview.id != null
    }
}
