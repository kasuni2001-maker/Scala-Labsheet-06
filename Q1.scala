object Q1 {
    def encrypt(text: String, shift: Int): String = {
      val encryptedText = text.map { c =>
        if (c.isLetter) {
          val base = if (c.isUpper) 'A' else 'a'
          val offset = (c - base + shift) % 26
          (base + offset).toChar
        } else {
          c
        }
      }
      encryptedText
    }

    def decrypt(text: String, shift: Int): String = {
      encrypt(text, 26 - shift)
    }

    def main(args: Array[String]): Unit = {
      println("Enter the text to encrypt:")
      val text = scala.io.StdIn.readLine()

      println("Enter the shift value (an integer):")
      val shift = scala.io.StdIn.readInt()

      val encryptedText = encrypt(text, shift)
      println(s"Encrypted text: $encryptedText")

      val decryptedText = decrypt(encryptedText, shift)
      println(s"Decrypted text: $decryptedText")
    }

}
