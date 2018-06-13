package team.store.redux

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProductReviewController {

    ProductReviewService productReviewService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond productReviewService.list(params), model:[productReviewCount: productReviewService.count()]
    }

    def show(Long id) {
        respond productReviewService.get(id)
    }

    def create() {
        respond new ProductReview(params)
    }

    def save(ProductReview productReview) {
        if (productReview == null) {
            notFound()
            return
        }

        try {
            productReviewService.save(productReview)
        } catch (ValidationException e) {
            respond productReview.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productReview.label', default: 'ProductReview'), productReview.id])
                redirect productReview
            }
            '*' { respond productReview, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond productReviewService.get(id)
    }

    def update(ProductReview productReview) {
        if (productReview == null) {
            notFound()
            return
        }

        try {
            productReviewService.save(productReview)
        } catch (ValidationException e) {
            respond productReview.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'productReview.label', default: 'ProductReview'), productReview.id])
                redirect productReview
            }
            '*'{ respond productReview, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        productReviewService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'productReview.label', default: 'ProductReview'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productReview.label', default: 'ProductReview'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
