import kotlin.random.Random


fun main() {

    val ecc = EllipticCurveCryptography(0.0,7.0)
    val generatorPoint = Point(2.0,-2.0)


    //generating random numbers
    val aliceKeyX =  Random.nextDouble(1e4)
    val aliceKeyY =  Random.nextDouble(1e4)
    val bobsKeyX =  Random.nextDouble(1e4)
    val bobsKeyY =  Random.nextDouble(1e4)


    println("Alice's generated numbers: $aliceKeyX   $aliceKeyY" )
    println("Bob's generated numbers: $bobsKeyX   $bobsKeyY" )

    val alicePrivateKey = Point(aliceKeyX,aliceKeyY)  //only Alice knows this key
    val bobPrivateKey = Point(bobsKeyX,bobsKeyY)    //only Bob knows this key


    //generate public key that the other person can see

    val alicePublicKey = ecc.pointAddition(alicePrivateKey,generatorPoint) // Bob will take this key
    val bobPublicKey = ecc.pointAddition(bobPrivateKey,generatorPoint) // Alice will take this key

    //Now they can each create their shared key
    val aliceSharedKey = ecc.pointAddition(alicePrivateKey,bobPublicKey) //Alice will encrypt using this key, and Bob will unlock it with his private key
    val bobSharedKey = ecc.pointAddition(bobPrivateKey,alicePublicKey) //Bob will encrypt using this key, and Alice will unlock it with her private key

    println("Alice's public key is $alicePublicKey")
    println("Bobs's public key is $bobPublicKey")
    println("Alice's shared key is $aliceSharedKey")
    println("Bobs's shared key is $bobSharedKey")
}