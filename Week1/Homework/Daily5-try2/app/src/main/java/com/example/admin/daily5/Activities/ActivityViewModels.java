package com.example.admin.daily5.Activities;

public class ActivityViewModels {
    public static class DataPersistence{

        private String FirstName;
        private String LastName;
        private String Name;

        public DataPersistence(){

        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }
    }
}
