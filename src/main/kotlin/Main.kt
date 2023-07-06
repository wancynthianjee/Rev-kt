fun main(){

    var story1= Storyteller("Buraje","The Two Huts","Kikuyu",)
    story1.tellStory()
    var story2= Translator("Wanjiru Shiku","The Ghost of Garbatula","Borana","Kiswahili")
    story2.translateStories()



    val recipes = Recipe(   arrayOf("Rice", "Spices"), "one hour",
        "fry the meat till golden under low heat", "proteins and energy")
    val ethiopianRecipe = EthiopianRecipe("grounded wheat", arrayOf("Wheat", "brown wheat"),
        " am maximum of three days",
        "ferment the flour the fry it under low heat for two minute",
        "energy"
    )
    ethiopianRecipe.ethiopiansSpecial()

    val recipe = Recipe(   arrayOf("Rice", "Spices"), "one hour",
        "fry the meat till golden under low heat", "proteins and energy")
    val nigerianRecipe = NigerianRecipe("grounded wheat", arrayOf("Wheat", "brown wheat"),
        " am maximum of three days",
        "ferment the flour the fry it under low heat for two minute",
        "energy"
    )
    nigerianRecipe.nigerianSpecial()


    val recipee = Recipe(   arrayOf("Rice", "Spices"), "one hour",
        "fry the meat till golden under low heat", "proteins and energy")
    val morrocanRecipe = MorrocanRecipe("grounded wheat", arrayOf("Wheat", "brown wheat"),
        " am maximum of three days",
        "ferment the flour the fry it under low heat for two minute",
        "energy"
    )

    val animal1 = Predator("Leopard", "meat", "30 years", "East to West", "spot and stalk")
    val currentLocation = "Savannah"
    val preyDistribution = listOf("Savannah", "Forest", "Grassland")
    val prediction = animal1.predictLocation(currentLocation, preyDistribution)
    println(prediction)

    val students = listOf(
        Student("Mercy Jebichi", 18, listOf(80, 75, 90)),
        Student("Feith Chepwogen", 19, listOf(70, 85, 65)),
        Student("Alice Ekeno", 20, listOf(90, 80, 95))
    )
    for (student in students) {
        println("Student information:")
        println("Name: ${student.name}")
        println("Age: ${student.age}")
        println("Grades: ${student.grades}")
        println("Average Grade: ${student.calculateAverageGrade()}")
        println("Passing Status: ${student.hasPassed()}")
        student.displayHighestGrade()
        println()
    }



}


//Questions

//1.**Ancestral Stories:** In many African cultures, the art of storytelling is passed
//down from generation to generation. Imagine you're creating an application that records these oral stories and translates them into different languages. The
//stories vary by length, moral lessons, and the age group they are intended for.
//Think about how you would model `Story`, `StoryTeller`, and `Translator`
//objects, and how inheritance might come into play if there are different types of
//stories or storytellers.


class Stories(var title:String,var morallesson:String,var description:String,var agegroup:String){


}
open class  Storyteller(var name:String,var title: String,var language:String){
    fun tellStory(){
        println("$name is telling $title in $language")
    }
}
class  Translator(name: String,title: String,language: String ,var targetLanguage:String):Storyteller( name,title,language){
    fun translateStories(){
        println("$name translates $title from $language to $targetLanguage ")
    }
}

//2. **African Cuisine:** You're creating a recipe app specifically for African cuisine.
//The app needs to handle recipes from different African countries, each with its
//unique ingredients, preparation time, cooking method, and nutritional
//information. Consider creating a `Recipe` class, and think about how you might
//create subclasses for different types of recipes (e.g., `MoroccanRecipe`,
//`EthiopianRecipe`, `NigerianRecipe`), each with their own unique properties and
//Methods.

open class Recipe(var ingredients: Array<String>, var preparationTime: String, val cookingMethod: String, var nutritionalValue: String) {

    fun getIngredients() {
        println("The ingredients is $ingredients")
    }

    fun getPreparationTime() {
        println("$preparationTime ")
    }

    fun getCookingMethod() {
        println("$cookingMethod")
    }

    fun getNutritionalInformation() {
        println("$nutritionalValue")
    }
}

class MorrocanRecipe(var specialIngredient: String, ingredients: Array<String>, preparationTime: String, cookingMethod: String,

                     nutritionalValue: String) : Recipe(ingredients, preparationTime, cookingMethod, nutritionalValue) {
    fun specialRecipe() {
        println("The special recipe of wheat is $specialIngredient")

    }
}

class EthiopianRecipe(var specialIngredient: String, ingredients: Array<String>, preparationTime: String, cookingMethod: String,
                      nutritionalValue: String) : Recipe(ingredients, preparationTime, cookingMethod, nutritionalValue) {

    fun ethiopiansSpecial() {
        println("The special recipe of injera is $specialIngredient")

    }
}

class NigerianRecipe(var specialIngredient: String, ingredients: Array<String>, preparationTime: String, cookingMethod: String,
                     nutritionalValue: String) : Recipe(ingredients, preparationTime, cookingMethod, nutritionalValue) {

    fun nigerianSpecial() {
        println("The special recipe of Jollof rice is $specialIngredient ")
    }
}

//
// 3. **Wildlife Preservation:** You're a wildlife conservationist working on a
// program to track different species in a national park. Each species has its own
// characteristics and behaviors, such as its diet, typical lifespan, migration
// patterns, etc. Some species might be predators, others prey. You'll need to
//
//create classes to model `Species`, `Predator`, `Prey`, etc., and think about how
//these classes might relate to each other through inheritance.
open class Species(val name: String, val diet: String, val lifespan: String, val migrationPatterns: String
) {
    open fun speciesInfo(): String {
        return "$name feeds on $diet, it has a lifespan of $lifespan and migrates $migrationPatterns"
    }
}
class Predator(name: String, diet: String, lifespan: String, migrationPatterns: String, val huntingMethod: String) : Species(name, diet, lifespan, migrationPatterns) {
    override fun speciesInfo(): String {
        return "${super.speciesInfo()} and hunts using $huntingMethod"
    }
    fun predictLocation(currentLocation: String, preyDistribution: List<String>): String {
        // Add your logic to predict the predator's location based on currentLocation and preyDistribution
        // For example, you can analyze habitat suitability and prey abundance to make predictions
        // This is a simplified example that assumes the predator's location is influenced by prey distribution
        return if (preyDistribution.contains(currentLocation)) {
            "The $name is likely to be found in $currentLocation where prey is abundant."
        } else {
            "The $name may have moved to a different location due to changes in prey distribution."
        }
    }
}

//4.**African Music Festival:** You're in charge of organizing a Pan-African music
//festival. Many artists from different countries, each with their own musical style
//and instruments are scheduled to perform. You need to write a program to
//manage the festival lineup, schedule, and stage arrangements. Think about how
//you might model the `Artist`, `Performance`, and `Stage` classes, and consider
//how you might use inheritance if there are different types of performances or stages.

//class Artist(val name: String, val country: String, val musicalStyle: String, val instruments: List<String>) {
//
//}
//class Performance(val artist: Artist, val startTime: String, val endTime: String, val stage: Stage) {
//}
//class Stage(val name: String, val capacity: Int, val location: String) {
//}

//4.**African Music Festival:** You're in charge of organizing a Pan-African music
//festival. Many artists from different countries, each with their own musical style
//and instruments are scheduled to perform. You need to write a program to
//manage the festival lineup, schedule, and stage arrangements. Think about how
//you might model the `Artist`, `Performance`, and `Stage` classes, and consider
//how you might use inheritance if there are different types of performances or stages.

//# 5. Create a class called Product with attributes for name, price, and quantity.
//# Implement a method to calculate the total value of the product (price * quantity).
//# Create multiple objects of the Product class and calculate their total values.

class Product(var name: String, var price: Double, var quantity: Int) {
    fun getTotalValue(): Double? {
        if (price > 0 && quantity > 0) {
            return price * quantity
        } else {
            return null
        }
    }
}



//6. Implement a class called Student with attributes for name, age, and grades (a
//list of integers). Include methods to calculate the average grade, display the
//student information, and determine if the student has passed (average grade >=
//60). Create objects for the Student class and demonstrate the usage of these
//methods.
class Student(val name: String, val age: Int, val grades: List<Int>) {
    fun calculateAverageGrade(): Double {
        val sum = grades.sum()
        return sum.toDouble() / grades.size
    }
    fun hasPassed(): Boolean {
        val averageGrade = calculateAverageGrade()
        return averageGrade >= 60
    }
    fun displayHighestGrade() {
        val highestGrade = grades.max()
        println("Highest Grade: $highestGrade")
    }
}



