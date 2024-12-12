package com.lingorise.app.domain.usecase.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class EnrollmentMethod(private val context: Context) {

    // to make sure there's only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("enrollmentMethod")
        val IS_MULTIPLE_PREF_KEY = booleanPreferencesKey("is_multiple")
    }

    //get the saved email
    val isMultiple: Flow<Boolean?> = context.dataStore.data
        .map { preferences ->
            preferences[IS_MULTIPLE_PREF_KEY] ?: false
        }

    //save email into datastore
    suspend fun enroll(isMultiple: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_MULTIPLE_PREF_KEY] = isMultiple
        }
    }


}