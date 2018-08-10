package com.example.admin.daily3week2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.daily3week2.models.Animal;
import com.example.admin.daily3week2.models.Category;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "ZooDB";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private void DropAllTables(SQLiteDatabase sqLiteDatabase){
        String dropCategoryTable = "DROP TABLE IF EXISTS "
                + Category.TableName_TAG;
        sqLiteDatabase.execSQL(dropCategoryTable);

        String dropAnimalTable = "DROP TABLE IF EXISTS "
                + Animal.TableName_TAG;
        sqLiteDatabase.execSQL(dropAnimalTable);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createCategoryTableQuery = "CREATE TABLE " + Category.TableName_TAG + "("
                + Category.CategoryId_TAG + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Category.CategoryName_TAG + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(createCategoryTableQuery);

        String createAnimalTableQuery = "CREATE TABLE " + Animal.TableName_TAG + "("
                + Animal.AnimalId_TAG + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Animal.Name_TAG + " TEXT,"
                + Animal.Description_TAG + " TEXT,"
                + Animal.PicturePath_TAG + " TEXT,"
                + Animal.SoundPath_TAG + " TEXT"
                + ")";
        sqLiteDatabase.execSQL(createAnimalTableQuery);
        
        GenerateDuummyDataSQL(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        DropAllTables(sqLiteDatabase);
        onCreate(sqLiteDatabase);
    }

    private void SaveCategory(Category category){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(Category.CategoryId_TAG, category.getCategoryId());
        contentValues.put(Category.CategoryName_TAG, category.getCategoryName());
        int result = (int)database.insert(Category.TableName_TAG, null, contentValues);
    }

    private void SaveCategory(Category category, SQLiteDatabase sqLiteDatabase){

        ContentValues contentValues = new ContentValues();
        //contentValues.put(Category.CategoryId_TAG, category.getCategoryId());
        contentValues.put(Category.CategoryName_TAG, category.getCategoryName());
        int result = (int)sqLiteDatabase.insert(Category.TableName_TAG, null, contentValues);
    }

    private void SaveAnimal(Animal animal){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(Animal.AnimalId_TAG, animal.getAnimalId());
        contentValues.put(Animal.Name_TAG, animal.getAnimalId());
        contentValues.put(Animal.Description_TAG, animal.getAnimalId());
        contentValues.put(Animal.PicturePath_TAG, animal.getAnimalId());
        contentValues.put(Animal.SoundPath_TAG, animal.getAnimalId());
        contentValues.put(Animal.CategoryId_TAG, animal.getCategoryId());
        int result = (int)database.insert(Animal.TableName_TAG, null, contentValues);
    }

    private void SaveAnimal(Animal animal, SQLiteDatabase sqLiteDatabase){
        ContentValues contentValues = new ContentValues();
        //contentValues.put(Animal.AnimalId_TAG, animal.getAnimalId());
        contentValues.put(Animal.Name_TAG, animal.getAnimalId());
        contentValues.put(Animal.Description_TAG, animal.getAnimalId());
        contentValues.put(Animal.PicturePath_TAG, animal.getAnimalId());
        contentValues.put(Animal.SoundPath_TAG, animal.getAnimalId());
        contentValues.put(Animal.CategoryId_TAG, animal.getCategoryId());
        int result = (int)sqLiteDatabase.insert(Animal.TableName_TAG, null, contentValues);
    }

    public List<Category> GetCategories(){
        List<Category> categoryList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + Category.TableName_TAG;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if(cursor.moveToNext()){
            do{
                Category category = new Category(cursor.getInt(0), cursor.getString(1));
                categoryList.add(category);
            }while(cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return categoryList;
    }

    public List<Animal> GetAnimals(){
        List<Animal> animalList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM " + Animal.TableName_TAG;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if(cursor.moveToNext()){
            do{
                Animal animal = new Animal(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5));
                animalList.add(animal);
            }while(cursor.moveToNext());
        }
        return animalList;
    }

    private void GenerateDuummyDataSQL(SQLiteDatabase sqLiteDatabase){
        SaveCategory(new Category("Mammals"), sqLiteDatabase);
        SaveCategory(new Category("Reptiles"), sqLiteDatabase);
        SaveCategory(new Category("Birds"), sqLiteDatabase);

        SaveAnimal(new Animal("Monkey", "The monkey is a mammal bla bla bla bla bla bla bla.","monkey.png", "monkey.mp3", 1), sqLiteDatabase);
        SaveAnimal(new Animal("Giraffe", "The giraffe is the tallest land living creature in the planet bla bla bla bla bla bla bla.","monkey.png", "monkey.mp3", 1), sqLiteDatabase);
        SaveAnimal(new Animal("Lion", "The lion is one big cat capable of bla bla bla bla bla bla bla.","monkey.png", "monkey.mp3", 1), sqLiteDatabase);
        SaveAnimal(new Animal("T-Rex", "The t-rex is a massive living predating machine bla bla bla bla bla bla bla.","monkey.png", "monkey.mp3", 2), sqLiteDatabase);
        SaveAnimal(new Animal("Green Iguana", "The green iguana bla bla bla bla bla bla bla.","monkey.png", "monkey.mp3", 2), sqLiteDatabase);
        SaveAnimal(new Animal("Cockatoo", "The cockatoo is one of the smartest birds of the planet bla bla bla bla bla bla bla.","monkey.png", "monkey.mp3", 3), sqLiteDatabase);
        SaveAnimal(new Animal("Hawk", "The hawk is a super fast bird bla bla bla bla bla bla bla.","monkey.png", "monkey.mp3", 3), sqLiteDatabase);
    }
}