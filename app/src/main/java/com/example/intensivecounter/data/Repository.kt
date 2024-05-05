package com.example.intensivecounter.data

interface Repository {

    fun getCounter(): Int
    fun isMax(): Boolean
    fun increment()
    fun reset()

    class Base : Repository {
        override fun getCounter(): Int {
            TODO("Not yet implemented")
        }

        override fun isMax(): Boolean {
            TODO("Not yet implemented")
        }

        override fun increment() {
            TODO("Not yet implemented")
        }

        override fun reset() {
            TODO("Not yet implemented")
        }
    }
}