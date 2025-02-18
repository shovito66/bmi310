package com.example.recyclerview
import android.widget.Toast
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemList = listOf(
            Item("1", "Item A", "$10", "ID001"),
            Item("2", "Item B", "$15", "ID002"),
            Item("3", "Item C", "$20", "ID003"),
            Item("4", "Item D", "$25", "ID004"),
            Item("5", "Item E", "$10", "ID005"),
            Item("6", "Item F", "$15", "ID006"),
            Item("7", "Item G", "$20", "ID007"),
            Item("8", "Item H", "$25", "ID008"),
        )

        val adapter = ItemAdapter(itemList) { itemId ->
            // Show a toast with the ID
            Toast.makeText(this, "Clicked Item ID: $itemId", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter
    }
}