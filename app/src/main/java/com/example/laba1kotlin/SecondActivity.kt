package com.example.laba1kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import java.io.StringReader

class SecondActivity : AppCompatActivity(), MyAdapter.MyClickListener {

    lateinit var recycleView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        recycleView = findViewById(R.id.recyclerView)

        var layoutManager = LinearLayoutManager(this)
        recycleView.layoutManager = layoutManager;
        recycleView.setHasFixedSize(true)

        class fu(val description : String, val format_version: String, val options : String)
        var flag = false
        val jsonString = """[
    {
        "description": "Classic technology data for Freeciv (as Civ2, minus a few)",
        "format_version": "10",
        "options": "+Freeciv-ruleset-Devel-2015.January.14 web-compatible"
    },
    {
        "flags": "",
        "graphic": "advanced_flight.jpg",
        "graphic_alt": "-",
        "name": "Advanced Flight",
        "req1": "Radio",
        "req2": "Machine Tools"
    },
    {
        "flags": "",
        "graphic": "alphabet.jpg",
        "graphic_alt": "-",
        "name": "Alphabet",
        "req1": "None",
        "req2": "None"
    },
    {
        "flags": "",
        "graphic": "amphibious_warfare.jpg",
        "graphic_alt": "-",
        "name": "Amphibious Warfare",
        "req1": "Navigation",
        "req2": "Tactics"
    },
    {
        "flags": "",
        "graphic": "astronomy.jpg",
        "graphic_alt": "-",
        "name": "Astronomy",
        "req1": "Mysticism",
        "req2": "Mathematics"
    },
    {
        "flags": "",
        "graphic": "atomic_theory.jpg",
        "graphic_alt": "-",
        "name": "Atomic Theory",
        "req1": "Theory of Gravity",
        "req2": "Physics"
    },
    {
        "graphic": "automobile.jpg",
        "graphic_alt": "-",
        "helptext": "Increases the population's contribution to pollution.",
        "name": "Automobile",
        "req1": "Combustion",
        "req2": "Steel"
    },
    {
        "flags": "",
        "graphic": "banking.jpg",
        "graphic_alt": "-",
        "name": "Banking",
        "req1": "Trade",
        "req2": "The Republic"
    },
    {
        "flags": "Bridge",
        "graphic": "bridge_building.jpg",
        "graphic_alt": "-",
        "helptext": "Allows roads to be built on river tiles.",
        "name": "Bridge Building",
        "req1": "Iron Working",
        "req2": "Construction"
    },
    {
        "flags": "",
        "graphic": "bronze_working.jpg",
        "graphic_alt": "-",
        "name": "Bronze Working",
        "req1": "None",
        "req2": "None"
    },
    {
        "flags": "",
        "graphic": "ceremonial_burial.jpg",
        "graphic_alt": "-",
        "name": "Ceremonial Burial",
        "req1": "None",
        "req2": "None"
    },
    {
        "flags": "",
        "graphic": "chemistry.jpg",
        "graphic_alt": "-",
        "name": "Chemistry",
        "req1": "University",
        "req2": "Medicine"
    },
    {
        "flags": "",
        "graphic": "chivalry.jpg",
        "graphic_alt": "-",
        "name": "Chivalry",
        "req1": "Feudalism",
        "req2": "Horseback Riding"
    },
    {
        "flags": "",
        "graphic": "code_of_laws.jpg",
        "graphic_alt": "-",
        "name": "Code of Laws",
        "req1": "Alphabet",
        "req2": "None"
    },
    {
        "flags": "",
        "graphic": "combined_arms.jpg",
        "graphic_alt": "-",
        "name": "Combined Arms",
        "req1": "Mobile Warfare",
        "req2": "Advanced Flight"
    },
    {
        "flags": "",
        "graphic": "combustion.jpg",
        "graphic_alt": "-",
        "name": "Combustion",
        "req1": "Refining",
        "req2": "Explosives"
    },
    {
        "flags": "",
        "graphic": "communism.jpg",
        "graphic_alt": "-",
        "helptext": "Reduces the effect of Cathedrals.",
        "name": "Communism",
        "req1": "Philosophy",
        "req2": "Industrialization"
    },
    {
        "flags": "",
        "graphic": "computers.jpg",
        "graphic_alt": "-",
        "name": "Computers",
        "req1": "Mass Production",
        "req2": "Miniaturization"
    },
    {
        "flags": "",
        "graphic": "conscription.jpg",
        "graphic_alt": "-",
        "name": "Conscription",
        "req1": "Democracy",
        "req2": "Metallurgy"
    },
    {
        "flags": "",
        "graphic": "construction.jpg",
        "graphic_alt": "-",
        "helptext": "Allows Settlers, Workers and Engineers to build fortresses.",
        "name": "Construction",
        "req1": "Masonry",
        "req2": "Currency"
    },
    {
        "flags": "",
        "graphic": "currency.jpg",
        "graphic_alt": "-",
        "name": "Currency",
        "req1": "Bronze Working",
        "req2": "None"
    },
    {
        "flags": "",
        "graphic": "democracy.jpg",
        "graphic_alt": "-",
        "name": "Democracy",
        "req1": "Banking",
        "req2": "Invention"
    },
    {
        "flags": "",
        "graphic": "economics.jpg",
        "graphic_alt": "-",
        "name": "Economics",
        "req1": "Banking",
        "req2": "University"
    },
    {
        "flags": "",
        "graphic": "electricity.jpg",
        "graphic_alt": "-",
        "helptext": "Improves the effect of Colosseums.",
        "name": "Electricity",
        "req1": "Metallurgy",
        "req2": "Magnetism"
    },
    {
        "flags": "",
        "graphic": "electronics.jpg",
        "graphic_alt": "-",
        "name": "Electronics",
        "req1": "The Corporation",
        "req2": "Electricity"
    },
    {
        "flags": "",
        "graphic": "engineering.jpg",
        "graphic_alt": "-",
        "name": "Engineering",
        "req1": "The Wheel",
        "req2": "Construction"
    },
    {
        "flags": "",
        "graphic": "environmentalism.jpg",
        "graphic_alt": "-",
        "name": "Environmentalism",
        "req1": "Recycling",
        "req2": "Space Flight"
    },
    {
        "flags": "",
        "graphic": "espionage.jpg",
        "graphic_alt": "-",
        "name": "Espionage",
        "req1": "Communism",
        "req2": "Democracy"
    },
    {
        "flags": "",
        "graphic": "explosives.jpg",
        "graphic_alt": "-",
        "name": "Explosives",
        "req1": "Gunpowder",
        "req2": "Chemistry"
    },
    {
        "flags": "",
        "graphic": "feudalism.jpg",
        "graphic_alt": "-",
        "name": "Feudalism",
        "req1": "Warrior Code",
        "req2": "Monarchy"
    },
    {
        "flags": "Build_Airborne",
        "graphic": "flight.jpg",
        "graphic_alt": "-",
        "helptext": "Decreases one-time revenue from new trade routes.",
        "name": "Flight",
        "req1": "Combustion",
        "req2": "Theory of Gravity"
    },
    {
        "flags": "",
        "graphic": "fusion_power.jpg",
        "graphic_alt": "-",
        "name": "Fusion Power",
        "req1": "Nuclear Power",
        "req2": "Superconductors"
    },
    {
        "flags": "",
        "graphic": "genetic_engineering.jpg",
        "graphic_alt": "-",
        "name": "Genetic Engineering",
        "req1": "Medicine",
        "req2": "The Corporation"
    },
    {
        "flags": "",
        "graphic": "guerilla_warfare.jpg",
        "graphic_alt": "-",
        "name": "Guerilla Warfare",
        "req1": "Communism",
        "req2": "Tactics"
    },
    {
        "flags": "",
        "graphic": "gunpowder.jpg",
        "graphic_alt": "-",
        "name": "Gunpowder",
        "req1": "Invention",
        "req2": "Iron Working"
    },
    {
        "flags": "",
        "graphic": "horseback_riding.jpg",
        "graphic_alt": "-",
        "name": "Horseback Riding",
        "req1": "None",
        "req2": "None"
    },
    {
        "graphic": "industrialization.jpg",
        "graphic_alt": "-",
        "helptext": "Population will start contributing to pollution.",
        "name": "Industrialization",
        "req1": "Railroad",
        "req2": "Banking"
    },
    {
        "flags": "",
        "graphic": "invention.jpg",
        "graphic_alt": "-",
        "helptext": "Increases units' vision when in fortresses.",
        "name": "Invention",
        "req1": "Engineering",
        "req2": "Literacy"
    },
    {
        "flags": "",
        "graphic": "iron_working.jpg",
        "graphic_alt": "-",
        "name": "Iron Working",
        "req1": "Bronze Working",
        "req2": "Warrior Code"
    },
    {
        "flags": "",
        "graphic": "labor_union.jpg",
        "graphic_alt": "-",
        "name": "Labor Union",
        "req1": "Mass Production",
        "req2": "Guerilla Warfare"
    },
    {
        "flags": "",
        "graphic": "laser.jpg",
        "graphic_alt": "-",
        "name": "Laser",
        "req1": "Mass Production",
        "req2": "Nuclear Power"
    },
    {
        "flags": "",
        "graphic": "leadership.jpg",
        "graphic_alt": "-",
        "name": "Leadership",
        "req1": "Chivalry",
        "req2": "Gunpowder"
    },
    {
        "flags": "",
        "graphic": "literacy.jpg",
        "graphic_alt": "-",
        "name": "Literacy",
        "req1": "Writing",
        "req2": "Code of Laws"
    },
    {
        "flags": "",
        "graphic": "machine_tools.jpg",
        "graphic_alt": "-",
        "name": "Machine Tools",
        "req1": "Steel",
        "req2": "Tactics"
    },
    {
        "flags": "",
        "graphic": "magnetism.jpg",
        "graphic_alt": "-",
        "helptext": "Allows establishing one more trade route from each city.",
        "name": "Magnetism",
        "req1": "Iron Working",
        "req2": "Physics"
    },
    {
        "flags": "",
        "graphic": "map_making.jpg",
        "graphic_alt": "-",
        "name": "Map Making",
        "req1": "Alphabet",
        "req2": "None"
    },
    {
        "flags": "",
        "graphic": "masonry.jpg",
        "graphic_alt": "-",
        "name": "Masonry",
        "req1": "None",
        "req2": "None"
    },
    {
        "graphic": "mass_production.jpg",
        "graphic_alt": "-",
        "helptext": "Increases the population's contribution to pollution.",
        "name": "Mass Production",
        "req1": "Automobile",
        "req2": "The Corporation"
    },
    {
        "flags": "",
        "graphic": "mathematics.jpg",
        "graphic_alt": "-",
        "name": "Mathematics",
        "req1": "Alphabet",
        "req2": "Masonry"
    },
    {
        "flags": "",
        "graphic": "medicine.jpg",
        "graphic_alt": "-",
        "name": "Medicine",
        "req1": "Philosophy",
        "req2": "Trade"
    },
    {
        "flags": "",
        "graphic": "metallurgy.jpg",
        "graphic_alt": "-",
        "name": "Metallurgy",
        "req1": "Gunpowder",
        "req2": "University"
    },
    {
        "flags": "",
        "graphic": "miniaturization.jpg",
        "graphic_alt": "-",
        "name": "Miniaturization",
        "req1": "Machine Tools",
        "req2": "Electronics"
    },
    {
        "flags": "",
        "graphic": "mobile_warfare.jpg",
        "graphic_alt": "-",
        "name": "Mobile Warfare",
        "req1": "Automobile",
        "req2": "Tactics"
    },
    {
        "flags": "",
        "graphic": "monarchy.jpg",
        "graphic_alt": "-",
        "name": "Monarchy",
        "req1": "Ceremonial Burial",
        "req2": "Code of Laws"
    },
    {
        "flags": "",
        "graphic": "monotheism.jpg",
        "graphic_alt": "-",
        "name": "Monotheism",
        "req1": "Philosophy",
        "req2": "Polytheism"
    },
    {
        "flags": "",
        "graphic": "mysticism.jpg",
        "graphic_alt": "-",
        "helptext": "Improves the effect of Temples.",
        "name": "Mysticism",
        "req1": "Ceremonial Burial",
        "req2": "None"
    },
    {
        "flags": "",
        "graphic": "navigation.jpg",
        "graphic_alt": "-",
        "name": "Navigation",
        "req1": "Seafaring",
        "req2": "Astronomy"
    },
    {
        "flags": "",
        "graphic": "nuclear_fission.jpg",
        "graphic_alt": "-",
        "name": "Nuclear Fission",
        "req1": "Mass Production",
        "req2": "Atomic Theory"
    },
    {
        "flags": "",
        "graphic": "nuclear_power.jpg",
        "graphic_alt": "-",
        "helptext": "Gives sea units one extra move.",
        "name": "Nuclear Power",
        "req1": "Nuclear Fission",
        "req2": "Electronics"
    },
    {
        "bonus_message": "Great philosophers from all the world join \nyour civilization: you learn %s immediately.",
        "flags": "Bonus_Tech",
        "graphic": "philosophy.jpg",
        "graphic_alt": "-",
        "name": "Philosophy",
        "req1": "Mysticism",
        "req2": "Literacy"
    },
    {
        "flags": "",
        "graphic": "physics.jpg",
        "graphic_alt": "-",
        "name": "Physics",
        "req1": "Literacy",
        "req2": "Navigation"
    },
    {
        "graphic": "plastics.jpg",
        "graphic_alt": "-",
        "helptext": "Increases the population's contribution to pollution.",
        "name": "Plastics",
        "req1": "Refining",
        "req2": "Space Flight"
    },
    {
        "flags": "",
        "graphic": "polytheism.jpg",
        "graphic_alt": "-",
        "name": "Polytheism",
        "req1": "Horseback Riding",
        "req2": "Ceremonial Burial"
    },
    {
        "flags": "",
        "graphic": "pottery.jpg",
        "graphic_alt": "-",
        "name": "Pottery",
        "req1": "None",
        "req2": "None"
    },
    {
        "flags": "",
        "graphic": "radio.jpg",
        "graphic_alt": "-",
        "helptext": "Allows Workers and Engineers to build airbases and buoys.",
        "name": "Radio",
        "req1": "Flight",
        "req2": "Electricity"
    },
    {
        "flags": "",
        "graphic": "railroad.jpg",
        "graphic_alt": "-",
        "helptext": "\nAllows Settlers, Workers and Engineers to upgrade roads to railroads.\n\nDecreases one-time revenue from new trade routes.\n",
        "name": "?tech:Railroad",
        "req1": "Steam Engine",
        "req2": "Bridge Building"
    },
    {
        "flags": "",
        "graphic": "recycling.jpg",
        "graphic_alt": "-",
        "name": "Recycling",
        "req1": "Mass Production",
        "req2": "Democracy"
    },
    {
        "flags": "",
        "graphic": "refining.jpg",
        "graphic_alt": "-",
        "name": "Refining",
        "req1": "Chemistry",
        "req2": "The Corporation"
    },
    {
        "flags": "",
        "graphic": "refrigeration.jpg",
        "graphic_alt": "-",
        "helptext": "\nAllows Settlers, Workers and Engineers to upgrade irrigation systems \nto farmland.\n",
        "name": "Refrigeration",
        "req1": "Sanitation",
        "req2": "Electricity"
    },
    {
        "flags": "",
        "graphic": "robotics.jpg",
        "graphic_alt": "-",
        "name": "Robotics",
        "req1": "Mobile Warfare",
        "req2": "Computers"
    },
    {
        "flags": "",
        "graphic": "rocketry.jpg",
        "graphic_alt": "-",
        "name": "Rocketry",
        "req1": "Advanced Flight",
        "req2": "Electronics"
    },
    {
        "flags": "",
        "graphic": "sanitation.jpg",
        "graphic_alt": "-",
        "name": "Sanitation",
        "req1": "Engineering",
        "req2": "Medicine"
    },
    {
        "flags": "",
        "graphic": "seafaring.jpg",
        "graphic_alt": "-",
        "name": "Seafaring",
        "req1": "Pottery",
        "req2": "Map Making"
    },
    {
        "flags": "",
        "graphic": "space_flight.jpg",
        "graphic_alt": "-",
        "name": "Space Flight",
        "req1": "Computers",
        "req2": "Rocketry"
    },
    {
        "flags": "",
        "graphic": "stealth.jpg",
        "graphic_alt": "-",
        "name": "Stealth",
        "req1": "Superconductors",
        "req2": "Advanced Flight"
    },
    {
        "flags": "",
        "graphic": "steam_engine.jpg",
        "graphic_alt": "-",
        "name": "Steam Engine",
        "req1": "Physics",
        "req2": "Invention"
    },
    {
        "flags": "",
        "graphic": "steel.jpg",
        "graphic_alt": "-",
        "name": "Steel",
        "req1": "Electricity",
        "req2": "Industrialization"
    },
    {
        "flags": "",
        "graphic": "superconductors.jpg",
        "graphic_alt": "-",
        "name": "Superconductors",
        "req1": "Nuclear Power",
        "req2": "Laser"
    },
    {
        "flags": "",
        "graphic": "tactics.jpg",
        "graphic_alt": "-",
        "name": "Tactics",
        "req1": "Conscription",
        "req2": "Leadership"
    },
    {
        "flags": "",
        "graphic": "the_corporation.jpg",
        "graphic_alt": "-",
        "helptext": "Allows establishing one more trade route from each city.",
        "name": "The Corporation",
        "req1": "Economics",
        "req2": "Industrialization"
    },
    {
        "flags": "",
        "graphic": "the_republic.jpg",
        "graphic_alt": "-",
        "name": "The Republic",
        "req1": "Code of Laws",
        "req2": "Literacy"
    },
    {
        "flags": "",
        "graphic": "the_wheel.jpg",
        "graphic_alt": "-",
        "name": "The Wheel",
        "req1": "Horseback Riding",
        "req2": "None"
    },
    {
        "flags": "",
        "graphic": "theology.jpg",
        "graphic_alt": "-",
        "helptext": "Improves the effect of Cathedrals.",
        "name": "Theology",
        "req1": "Feudalism",
        "req2": "Monotheism"
    },
    {
        "flags": "",
        "graphic": "theory_of_gravity.jpg",
        "graphic_alt": "-",
        "name": "Theory of Gravity",
        "req1": "Astronomy",
        "req2": "University"
    },
    {
        "flags": "",
        "graphic": "trade.jpg",
        "graphic_alt": "-",
        "name": "Trade",
        "req1": "Currency",
        "req2": "Code of Laws"
    },
    {
        "flags": "",
        "graphic": "university.jpg",
        "graphic_alt": "-",
        "name": "University",
        "req1": "Mathematics",
        "req2": "Philosophy"
    },
    {
        "flags": "",
        "graphic": "warrior_code.jpg",
        "graphic_alt": "-",
        "name": "Warrior Code",
        "req1": "None",
        "req2": "None"
    },
    {
        "flags": "",
        "graphic": "writing.jpg",
        "graphic_alt": "-",
        "name": "Writing",
        "req1": "Alphabet",
        "req2": "None"
    }
]"""

        val klaxon = Klaxon()
        val techList = arrayListOf<MyAdapter.Technology>()

            JsonReader(StringReader(jsonString)).use { reader ->
                reader.beginArray {
                    while (reader.hasNext()) {
                        if (flag)
                        {
                            val tech = klaxon.parse<MyAdapter.Technology>(reader)
                            techList.add(tech!!)
                        }
                        else
                        {
                            val temp = klaxon.parse<fu>(reader)
                            flag = true
                        }
                    }
                }
            }

        recycleView.adapter = MyAdapter(techList, this, this)
    }

    override fun onItemClick(item: MyAdapter.Technology, position: Int) {
        val viewActivityIntent = Intent(this, ViewActivity::class.java)
        viewActivityIntent.putExtra("current", position)
        startActivity(viewActivityIntent)
    }
}
