{-|
Module      : StackADT
Description : Provides the class for the Stack ADT
Copyright   : Estructuras de Datos y Alg. UNRC
License     : GPL-3
We use haddock style of comments
-}

module StackADT where

-- | A class for stacks:
-- s is a type constructor, for example: lists.
class Stack s where 
    -- | empty Stack
    empty :: s a -> s a
    -- | push an element into the Stack
    push :: s a -> a -> s a

    -- | pop an element from the Stack
    pop :: s a -> s a -> a

    -- | check if is the Stack empty
    isEmpty :: s a -> Bool

    -- | obtain the top from the Stack
    top :: s a -> a