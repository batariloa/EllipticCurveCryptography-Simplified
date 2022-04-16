class EllipticCurveCryptography(val a: Double, val b: Double) {

    fun pointAddition(p:Point, q:Point):Point{

        val x1= p.x
        val y1 = p.y
        val x2 = q.x
        val y2 = q.y

        val m:Double

        if(x1==x2 && y1==y2)
        m =  (3*x1*x1+a) / (2*y1)

            else
                m=(y2-y1) / (x2-x1)

        val x3:Double = m*m - x1 - x2
        val y3:Double = m*(x1-x3)-y1

        return Point(x3, y3)

    }
}