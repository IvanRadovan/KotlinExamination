package Inlämningsuppgift2

class Tomteland {

    private val hierarchy: MutableMap<String, List<String>> = mutableMapOf(
            "Tomten" to listOf("Glader", "Butter"),
            "Glader" to listOf("Tröger", "Trötter", "Blyger"),
            "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
            "Trötter" to listOf("Skumtomten"),
            "Skumtomten" to listOf("Dammråttan"),
            "Räven" to listOf("Gråsuggan", "Myran"),
            "Myran" to listOf("Bladlusen")
    )

    fun getUnderlings(currentName: String): MutableList<String> {
        if (hierarchy.containsKey(currentName)) {
            val allUnderlings = mutableListOf<String>()
            val directUnderlings = hierarchy[currentName]

            directUnderlings?.let { allUnderlings.addAll(it) }
            directUnderlings?.forEach { e -> allUnderlings.addAll(getUnderlings(e)) }

            return allUnderlings
        }
        return mutableListOf()
    }
}
