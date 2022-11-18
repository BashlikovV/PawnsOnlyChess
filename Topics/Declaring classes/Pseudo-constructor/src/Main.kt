class Point3D(var x: Int, var y: Int, var z: Int) {

}

fun createPoint(x: Int, y: Int, z: Int): Point3D {
    return Point3D(x, y, z)
}