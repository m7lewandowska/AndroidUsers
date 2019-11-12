class User(firstName: String, lastName: String)
{
    /*    var userName: String = ""
    var userSurname: String = ""*/

    var userName = firstName
    var userSurname = lastName

    companion object {

        var ID = 1
    }

    var id: Int = 1

    init {

        id = ID
        ID++

    }

}
