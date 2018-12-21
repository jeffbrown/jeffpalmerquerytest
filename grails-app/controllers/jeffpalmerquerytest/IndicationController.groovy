package jeffpalmerquerytest

class IndicationController {

    def index(Integer max) {
        params.max = Math.min(max ?: 20, 100)
        respond Indication.list(params), model: [indicationInstanceCount: Indication.count()]
    }
}
