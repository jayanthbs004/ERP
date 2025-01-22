/* global use, db */
// MongoDB Playground
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.

const database = 'employee_db';
const collection = 'employees';

try {
    // The current database to use.
    use(database);

    // Drop the collection if it already exists to avoid duplicate entries during testing
    if (db.getCollection(collection).exists()) {
        db.getCollection(collection).drop();
        console.log(`Dropped existing collection: ${collection}`);
    }

    // Create a new collection.
    db.createCollection(collection);
    console.log(`Created collection: ${collection}`);

    // Insert sample documents into the employees collection.
    db.getCollection(collection).insertMany([
        { 'name': 'John Doe', 'position': 'Developer', 'salary': 60000 },
        { 'name': 'Jane Smith', 'position': 'Manager', 'salary': 80000 },
        { 'name': 'Alice Johnson', 'position': 'Designer', 'salary': 70000 },
    ]);
    console.log('Inserted sample documents into the collection.');

    // Run a find command to view all employees.
    const allEmployees = db.getCollection(collection).find().toArray();
    console.log('All Employees:', allEmployees);

    // Verify the collection creation
    const collections = db.getCollectionNames();
    console.log('Collections in the database:', collections);
} catch (error) {
    console.error('An error occurred:', error);
}

// The prototype form to create a collection:
/* db.createCollection( <name>,
  {
    capped: <boolean>,
    autoIndexId: <boolean>,
    size: <number>,
    max: <number>,
    storageEngine: <document>,
    validator: <document>,
    validationLevel: <string>,
    validationAction: <string>,
    indexOptionDefaults: <document>,
    viewOn: <string>,
    pipeline: <pipeline>,
    collation: <document>,
    writeConcern: <document>,
    timeseries: { // Added in MongoDB 5.0
      timeField: <string>, // required for time series collections
      metaField: <string>,
      granularity: <string>,
      bucketMaxSpanSeconds: <number>, // Added in MongoDB 6.3
      bucketRoundingSeconds: <number>, // Added in MongoDB 6.3
    },
    expireAfterSeconds: <number>,
    clusteredIndex: <document>, // Added in MongoDB 5.3
  }
)*/

// More information on the `createCollection` command can be found at:
// https://www.mongodb.com/docs/manual/reference/method/db.createCollection/
