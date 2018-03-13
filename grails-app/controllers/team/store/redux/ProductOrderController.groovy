package team.store.redux

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProductOrderController {

    ProductOrderService productOrderService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond productOrderService.list(params), model:[productOrderCount: productOrderService.count()]
    }

    def show(Long id) {
        respond productOrderService.get(id)
    }

    def create() {
        respond new ProductOrder(params)
    }

    def save(ProductOrder productOrder) {
        if (productOrder == null) {
            notFound()
            return
        }

        try {
            productOrderService.save(productOrder)
        } catch (ValidationException e) {
            respond productOrder.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productOrder.label', default: 'ProductOrder'), productOrder.id])
                redirect productOrder
            }
            '*' { respond productOrder, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond productOrderService.get(id)
    }

    def update(ProductOrder productOrder) {
        if (productOrder == null) {
            notFound()
            return
        }

        try {
            productOrderService.save(productOrder)
        } catch (ValidationException e) {
            respond productOrder.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'productOrder.label', default: 'ProductOrder'), productOrder.id])
                redirect productOrder
            }
            '*'{ respond productOrder, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        productOrderService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'productOrder.label', default: 'ProductOrder'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productOrder.label', default: 'ProductOrder'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
