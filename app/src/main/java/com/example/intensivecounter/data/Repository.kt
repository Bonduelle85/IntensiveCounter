package com.example.intensivecounter.data

interface Repository {

    fun getCounter(): Int
    fun isMax(): Boolean
    fun increment()
    fun reset()

    class Base(
        private val permanentStorage: PermanentStorage
    ) : Repository {
        override fun getCounter(): Int {
            return permanentStorage.read(KEY, DEFAULT_VALUE)
        }

        override fun isMax(): Boolean {
            val value = permanentStorage.read(KEY, DEFAULT_VALUE)
            return value == COUNTER_MAX_VALUE
        }

        override fun increment() {
            val oldValue = permanentStorage.read(KEY, DEFAULT_VALUE)
            val newValue = oldValue + 1
            permanentStorage.save(newValue, KEY)
        }

        override fun reset() {
            permanentStorage.save(INITIAL_VALUE, KEY)
        }


        companion object{
            const val KEY = "key"
            const val INITIAL_VALUE = 0
            const val DEFAULT_VALUE = 0
            const val COUNTER_MAX_VALUE = 10
        }
    }
}