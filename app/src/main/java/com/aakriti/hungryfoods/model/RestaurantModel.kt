package com.aakriti.hungryfoods.model
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class RestaurantModel (
        var resId: String ="",
        var resCost: String = "",
        var resImage: Int = 0,
        var resName: String= "",
        var resRating: String = "",
        var fvResIcon:Int=0,
        var resTiming:String="0"
)
      /*  constructor():this("","","",""){

        }
        constructor(
            resCost: String,
            resImage: String,
            resName: String,
            resRating: String
        ) {
            this.resName = resName
            this.resRating = resRating
            this.resCost = resCost
            this.resImage = resImage
        }
*/
    /*fun getCost(): String {
        return resCost
    }

    fun setCost(resCost: String) {
        this.resCost = resCost
    }

    fun getImage(): String {
        return resImage
    }

    fun setImage(resImage: String) {
        this.resImage = resImage
    }

        fun getName(): String {
            return resName
        }

        fun setName(resName: String) {
            this.resName = resName
        }

        fun getRating(): String? {
            return resRating
        }

        fun setRating(resRating: String) {
            this.resRating = resRating
        }

*/



